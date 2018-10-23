'use strict'
const merge = require('webpack-merge')
const prodEnv = require('./prod.env')
const NODE_ENV = '"development"';

module.exports = merge(prodEnv, {
  NODE_ENV: NODE_ENV,
  ACTUATOR: {
    info: {
      app: {
        environment: NODE_ENV,
      }
    }
  }
})
