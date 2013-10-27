
.PHONY: all jar run reload test install

all:
	sbt compile

jar:
	sbt assembly

run:
	sbt run

reload:
	sbt reload update-classifiers eclipse

test:
	sbt test

install:
	sbt publishLocal publishM2
