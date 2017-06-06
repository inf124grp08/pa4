var form = document.getElementById('form-order-form');


var validatorsReq = new XMLHttpRequest();
validatorsReq.addEventListener('load', function() {
  var validators = JSON.parse(this.responseText);

  var taxEl = document.getElementById('tax');
  var qtyEl = document.getElementById('qty');
  var subtotalEl = document.getElementById('subtotal');
  var priceEl = document.getElementById('price');
  var totalEl = document.getElementById('total');

  function updateTotal() {
    var tax = parseFloat(taxEl.innerText);
    var qty = parseInt(qtyEl.value);
    var price = parseInt(priceEl.innerText);
    var subtotal = qty * price;
    var total = (subtotal * tax) + subtotal;
    subtotalEl.innerText = subtotal;
    totalEl.innerText = total;
  }

  // qty autoupdate
  qtyEl.addEventListener('change', function() {
    updateTotal();
  });

  // zip autofill
  var zipInput = document.getElementById("zip");
  var vZip = validators.find(i=>i.name==="zip");
  var vZipRegex = new RegExp(vZip.regex);
  zipInput.addEventListener('keyup', function() {
    if (vZipRegex.test(zipInput.value)) {
      var getPlaceXHR = new XMLHttpRequest();
      getPlaceXHR.addEventListener('load', function() {
        var place = JSON.parse(this.responseText);
        var taxEl = document.getElementById('tax');
        if ( place ) {
          document.getElementById('state').value = place.state;
          document.getElementById('city').value = place.city;
          taxEl.innerText = place.taxrate;
        } else {
          taxEl.innerText = 0;
        }
        updateTotal();
      });
      getPlaceXHR.open('GET', `get-place.php?zip=${zipInput.value}`);
      getPlaceXHR.send();
    }
  });

  // cc logo
  var ccLogo = document.getElementById("cc-logo");
  var cc1 = document.getElementById("cc1");
  cc1.addEventListener('keyup', function() {
    var getLogoXHR = new XMLHttpRequest();
    getLogoXHR.addEventListener('load', function() {
      ccLogo.src = this.responseText;
    });
    getLogoXHR.open('GET', `get-card.php?creditCard1=${cc1.value}`);
    getLogoXHR.send();
  });

  // submission 
  form.addEventListener('submit', (e)=>{
    e.preventDefault();
    var data = new FormData(form);

    function validate() {
      var errors = [];
      validators.forEach(vfield => {
        var regex = new RegExp(vfield.regex);
        var val = data.get(vfield.name);
        if (!regex.test(val)) {
          if ( vfield.message ) {
            errors.push(vfield.message);
          } else {
            errors.push(`${vfield.name} is not valid`);
          }
        }
      })
      return errors;
    }

    var errors = validate();
    if ( errors.length === 0 ) {
      form.submit();
    } else {
      alert(errors.join('\n'));
    }
  });
});
validatorsReq.open('GET', 'validators.json');
validatorsReq.send();

