const NODE_ENV = '"production"';
const APP_VERSION = require('../package').version;
const GIT_BRANCH = process.env.GIT_BRANCH;
const GIT_COMMIT_ID = process.env.GIT_COMMIT_ID;
const GIT_COMMIT_TIME = process.env.GIT_COMMIT_TIME;
const CI_BUILD_TIME = process.env.CI_BUILD_TIME;
const CI_PIPELINE_ID = process.env.CI_PIPELINE_ID;
const CI_PIPELINE_PRE_URL = process.env.CI_PIPELINE_PRE_URL;

module.exports = {
  NODE_ENV: NODE_ENV,

  ACTUATOR: {
    info: {
      app: {
        environment: NODE_ENV,
        version: JSON.stringify(APP_VERSION)
      },
      build: {
        time: JSON.stringify(CI_BUILD_TIME),
        pipeline: JSON.stringify(CI_PIPELINE_PRE_URL + CI_PIPELINE_ID)
      },
      git: {
        branch: JSON.stringify(GIT_BRANCH),
        commit: {
          id: JSON.stringify(GIT_COMMIT_ID),
          time: JSON.stringify(GIT_COMMIT_TIME)
        }
      }
    }
  }

}
