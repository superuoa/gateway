1.Request a Remote OpenShift Lab Environment

2.Open terminal use command Login

```
$ oc login --insecure-skip-tls-verify  --server=https://master00-XXXX.generic.opentlc.com:443
```

3.Create the OpenShift projects

```
$ export COOLSTORE_PRJ=simple-project

$ oc new-project ${COOLSTORE_PRJ}

$ oc project $COOLSTORE_PRJ

```


4.Deploy the Gateway service application on OpenShift using the Fabric8 Maven plug-in

```
$ cd ~/lab/gateway

$ mvn clean fabric8:deploy -Popenshift -Dfabric8.namespace=$COOLSTORE_PRJ
```

5.Test Service

```
$ export GATEWAY_URL=http://$(oc get route gateway -n $COOLSTORE_PRJ -o template --template='{{.spec.host}}')

$ curl -X GET "$GATEWAY_URL/gateway/projects"
$ curl -X GET "$GATEWAY_URL/gateway/projects/{projectId}"
$ curl -X GET "$GATEWAY_URL/gateway/projects/status/{theStatus}"
$ curl -X GET "$GATEWAY_URL/gateway/freelancers"
$ curl -X GET "$GATEWAY_URL/gateway/freelancers/{freelancerId}"

```
