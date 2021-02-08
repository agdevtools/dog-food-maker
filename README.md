# dog-food-maker

For using docker with this project

clone git repository:

git clone https://github.com/wurstmeister/kafka-docker.git 

cd kafka-docker

Copy the docker-compose.yml file from this project into the directory

DNSHOST={your-external-facing-ip-address} docker-compose up -d

Note you can use your internal address if you are just planning on running locally.

You can also declare your variable (DNSHOST) in a .env file in the directory above and just run:

docker-compose up -d

docker-compose should pick up the envar automatically from the .env file. 

docker-compose down

will bring everything back down.

To make the metrics from kafka available for prometheus you need to expose them using the following docker image:

docker run --name kafka-jmx-endpoint -d  -ti  -p 9308:9308 danielqsj/kafka-exporter  --kafka.server={DNSHOST}:9092

Now in prometheus can you add this endpoint to the targets it scrapes from. I have added an example prometheus.yml file to the root of this project.
