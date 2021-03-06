all:
	make api
	make app

api:
	cd api && make build

app:
	cd app && make build

build: clean
	make api
	make app
	make restart

restart:
	-tstop
	tstart

clean:
	cd api && make clean
	cd app && make clean

.PHONY: api app build restart clean
