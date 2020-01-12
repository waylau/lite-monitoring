# Lite Monitoring

Lite Monitoring is a fast, lite and cross-platform open source monitoring solution for operating systems monitoring. It has the ability to collect system information, such as OS version, processes, memory &amp; CPU usage, disks &amp; partitions, devices, sensors, etc.

Lite Monitoring based on Netty, [Lite](https://github.com/waylau/lite), [OSHI](https://github.com/oshi/oshi) and MySQL.

## Supported platforms 


Windows • Linux • Mac OS X • Unix (Solaris, FreeBSD) 


## Supported features 


* Computer System and firmware, baseboard 
* Operating System and Version/Build
* Physical (core) and Logical (hyperthreaded) CPUs 
* System and per-processor load % and tick counters
* CPU uptime, processes, and threads
* Process uptime, CPU, memory usage
* Physical and virtual memory used/available
* Mounted filesystems (type, usable and total space)
* Disk drives (model, serial, size) and partitions
* Network interfaces (IPs, bandwidth in/out)
* Battery state (% capacity, time remaining)
* Connected displays (with EDID info)
* USB Devices
* Sensors (temperature, fan speeds, voltage)
* HTTP/HTTPS web UI support
* Lightweight and fast UI


## How to 

Build all applications:

```
mvn clean package
```


Run lite-monitoring-server application:

```
java -jar target/lite-monitoring-server-1.0.0.jar 
```


Run lite-monitoring-client application with lite-monitoring-server's url and port:

```
java -jar target/lite-monitoring-client-1.0.0.jar --server=127.0.0.1 --port=8082
``` 



Multi-instance deployment with lite-monitoring-web

```
java -jar target/lite-monitoring-web-1.0.0.jar --port=8080

java -jar target/lite-monitoring-web-1.0.0.jar --port=8081

java -jar target/lite-monitoring-web-1.0.0.jar --port=8082
```


## UI

See [lite-monitoring-ui](https://github.com/waylau/lite-monitoring-ui).
