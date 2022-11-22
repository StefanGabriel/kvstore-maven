# kvstore-maven

To generate the docker image, run the following command:
```
docker build -t kvstore-maven . 
```
To fire a new container, run:
```
docker run -p 26658:26658 kvstore-maven
```
If you want to run in detached mode, you can use:
````
docker run -dp 26658:26658 kvstore-maven
````
