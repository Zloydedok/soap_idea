'use strict'
const merge = require('webpack-merge')
const devEnv = require('./dev.env')
const NODE_ENV = '"testing"';

module.exports = merge(devEnv, {
  NODE_ENV: NODE_ENV,
  ACTUATOR: {
    info: {
      app: {
        environment: NODE_ENV,
      }
    }
  }
})
