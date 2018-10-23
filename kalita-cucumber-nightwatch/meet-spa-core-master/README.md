# vue-typescript-seed

> A Vue.js seed project with TypeScript, TS-Jest, Nightwatch and ESlint

It's highly recommended to use [Yarn](https://yarnpkg.com/en/) for this project 

Unit tests are done with Jest.
e2e tests are based on Nightwatch and Cucumber.

## How to run
``` bash
# Install dependencies
yarn
OR
npm install

# Serve with hot reload at localhost:8080
yarn run dev

# Build for production with minification
yarn run build

# Run unit tests
yarn run unit
# Report will be located at: test/unit/reports/test-report.html
# Coverage report will be located at: test/unit/reports/coverage/index.html

# Run e2e tests with output to console
yarn run e2e

# Generate HTML report (after running e2e)
yarn run e2e-html-report
# Report will be located at: test/e2e/reports/html/cucumber_report.html

# Perform ESLint code check
yarn run lint
```

## Other commands
```
# build for production and view the bundle analyzer report
yarn run build --report

# Run unit tests in watch mode for development
yarn run unit-watch

# Perform ESLint code check + autofix all possible issues
yarn run lint --fix
```

## WebStorm / Intellij IDEA configuration

Enable ESlint plugin, Vue plugin and TypeScript integration.
All of these should work by default.

### Unit testing via Jest

1. Click Run in the main toolbar
2. Edit Configurations
3. On the top left of the Run/Debug Configurations dialog, click the + sign.
4. Choose Jest
5. Name the new configuration "Jest"
6. Under "Configuration file" enter `{YOUR_PATH}\test\unit\jest.conf.js` (be sure to change {YOUR_PATH})
7. Click Apply 

You can now both run Unit tests and debug them inside the IDE.

### e2e testing via Nightwatch

1. Click Run in the main toolbar
2. Edit Configurations
3. On the top left of the Run/Debug Configurations dialog, click the + sign.
4. Choose Node.js
5. Name the new configuration "Nightwatch"
6. Under "JavaScript file" enter `node_modules\nightwatch\bin\runner.js`
7. Under "Application parameters" enter `--config test/e2e/nightwatch.conf.js --env chrome`
8. Click Apply 

You can now both run e2e tests and debug them inside the IDE.

**Note that this is different from running via console** `yarn run e2e` 
**which also starts the http server and checks if port is in use.**

**If your app is not served at default port (8080), change devServerURL in** `nightwatch.conf.js`

**For this to work you will need a running SPA in background, e.g. run** `yarn run dev` **and start e2e in IDE afterwards.**

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).


## How to deploy

Deploy could be fully done with maven or with manual command staging distribution

### With maven

You need to setup some environment variables before you will start (valid for Windows 10 Docker)

`DOCKER_TLS_VERIFY=0`

`DOCKER_HOST=tcp://localhost:2375`

`KUBECONFIG=c:\Users\username\.kube\config`

#### To deploy locally 

Do the following

Singleline

    mvn clean deploy -Dkubernetes.namespace=default -Dkubernetes.docker.registry.secret= -Dkubernetes.image.pullPolicy=IfNotPresent -Ddocker.registry=local -Dserver.port=80 -Dmaven.deploy.skip=true -Ddockerfile.push.skip=true 

Multiline

    mvn clean deploy \
    -Dkubernetes.namespace=default \
    -Dkubernetes.docker.registry.secret= \
    -Dkubernetes.image.pullPolicy=IfNotPresent \
    -Ddocker.registry=local \
    -Dserver.port=80 \
    -Dmaven.deploy.skip=true \
    -Ddockerfile.push.skip=true
    
Explanation

    # Execute clean deploy
    mvn clean deploy \
    # Set namespace for kubernetes 
    -Dkubernetes.namespace=default \
    # Set secret to push container from registry (empty for local deployment)
    -Dkubernetes.docker.registry.secret= \
    # Image will be in our Docker cache after build, so we don't need to push it 
    -Dkubernetes.image.pullPolicy=IfNotPresent \
    # We are not pushing image anywhere, so put any value here
    -Ddocker.registry=local \
    # Service port tu use
    -Dserver.port=80 \
    # Skip jar artifact deployment, since we are operating images
    -Dmaven.deploy.skip=true \
    # Skip image push
    -Ddockerfile.push.skip=true

#### To deploy on remote cluster 

1. Set `KUBECONFIG` env var to remote cluster config location

2. Set `kubernetes.docker.registry.secret` maven variable to secret name with container registry credentials located on Kubernetes cluster. Secret stub

        kind: Secret
        apiVersion: v1
        metadata:
          name: my-cr-secret
          namespace: dih-dev
        data:
          .dockerconfigjson: base64String
        type: kubernetes.io/dockerconfigjson

3. Set `kubernetes.namespace` to desired namespace. Namespace stub is

        kind: Namespace
        apiVersion: v1
        metadata:
          name: my-namespace

3. Set `kubernetes.image.pullPolicy` maven variable to `Always` to allow kubernetes pull image on deployment change

4. Set `docker.registry` maven variable to real docker registry reachable by k8s cluster

5. Remove `dockerfile.push.skip` maven variable 

6. Add `dockerfile.useMavenSettingsForAuth` maven variable set to `true`. Add to your maven `settings.conf` a new server

        <server>
          <id>myregistry.azurecr.io</id>
          <username>user</username>
          <password>pwd</password>
        </server>
      

Resulting command is

Singleline

    mvn clean deploy -Dkubernetes.namespace=default -Dkubernetes.docker.registry.secret=secretname  -Dkubernetes.image.pullPolicy=Always -Ddocker.registry=myregistry.azurecr.io -Dserver.port=80 -Dmaven.deploy.skip=true -Ddockerfile.useMavenSettingsForAuth=true 

Multiline

    mvn clean deploy \
    -Dkubernetes.namespace=default \
    -Dkubernetes.docker.registry.secret=secretname \
    -Dkubernetes.image.pullPolicy=Always \
    -Ddocker.registry=myregistry.azurecr.io \
    -Dserver.port=80 \
    -Dmaven.deploy.skip=true \
    -Ddockerfile.useMavenSettingsForAuth=true 

### With manual staging

    # install dependencies
    yarn install
    # process resources
    mvn resources:resources -Dkubernetes.namespace=default -Dkubernetes.docker.registry.secret= -Dkubernetes.image.pullPolicy=IfNotPresent -Ddocker.registry=local -Dserver.port=80 
    # build app
    yarn run build
    # run unit tests
    yarn run unit
    # run e2e tests
    yarn run e2e
    # copy result to target folder
    cp dist/ target/
    # build image
    docker build -f target/Dockerfile -t reponame/appname:appversion target/
    # push image
    docker push reponame/appname:appversion 
    # apply kubernetes deployments
    kubectl apply -f target/config/kubernetes/deployment.yml
    kubectl apply -f target/config/kubernetes/service.yml
   


