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
Initialize the database
```
sudo docker exec -it 7e5be3ed9519 bash
mysql --user=root --password=sapass
CREATE DATABASE `authdb` default character set utf8 default collate utf8_bin;
CREATE USER 'dbuser' IDENTIFIED BY 'dbpass';
GRANT SELECT, INSERT, UPDATE, DELETE ON `authdb`.* TO 'dbuser'@'%' IDENTIFIED BY 'dbpass';
CREATE USER 'dbadmin' IDENTIFIED BY 'adminpass';
GRANT ALL privileges ON `authdb`.* TO 'dbadmin'@'%';
FLUSH PRIVILEGES;

```
