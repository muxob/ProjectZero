# ProjectZero
##  Database
The database used is MariaDB, working on port 3306. Password is generated with
```
kubectl create secret generic pz-dev-secrets --from-literal=dbpassword=THE_PASSWORD
```
Persistent storage and database deployment and service are created with
```
kubectl create -f volume-dev.yaml
kubectl create -f db-dev-deployment.yaml
```
