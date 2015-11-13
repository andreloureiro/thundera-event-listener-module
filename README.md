# Thundera Event Register Module

A Node module to register events created on Resolve applications

This module has only one public method, the `registerEvent`.

It receives an event type and the payload data for the event. Then, it validates against the events schemas registered in this module. If it's all ok, the event data is sent to the Events API.


## Usage


Insert NPM package dependency `"thundera-event-register-module": "git+ssh://git@github.com:apontador/thundera-event-register-module.git"`

`const eventRegisterModule = require('thundera-event-register-module');`

`eventRegisterModule.registerEvent('CHANNEL_STATUS_CHANGE', {id:'...', status: '...', ...});`


### CLI


- Watch `npm run watch`
- Build `npm run build`
- Generate Documentation `npm run generate-docs`
- Release `npm run release`

Note that `build` and `release` tasks output their generated files to `out` and `release` folders, respectively. The difference is that `build` and `watch` tasks use source maps, increasing compile time.


## Local development


You should have this tools installed:

- [JDK 8](http://www.oracle.com/technetwork/pt/java/javase/downloads/jdk8-downloads-2133151.html)
- [Leiningen](http://leiningen.org/)
- [Node 5](https://nodejs.org/en/)

Then `npm run start`


There's a `node-test` folder containing two files, `server.js` and `thundera.js`.

If you want to test the JS functionality of this module, you should do this:

- Install nodemon via `npm install -g nodemon`
- Open two terminals, run `nodemon server.js` and `nodemon thundera.js`
- Start `npm run watch`
- Set the `endpoint` variable in `src/thundera_event_register/api.cljs` to `http://localhost:9999`

The `thundera.js` file imports the Node module and register a fake event. You should see the event JSON in both client and server terminals.

Every change in the CLJS files will execute `thundera.js` again.

