import {Environment} from '../enums/Environment';

export default class Logger {
  static log(message?: {}, ...optionalParams: {}[]): void {
    if (ACTUATOR.info.app.environment.toLowerCase() !== Environment.production) {
      // eslint-disable-next-line no-console
      console.log(message, ...optionalParams);
    }
  }
}
