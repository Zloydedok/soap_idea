declare namespace Actuator {

  interface IActuator {
    info: IInfo
  }

  interface IInfo {
    app: IApp;
    git: IGit;
  }

  interface IApp {
    environment: string;
    version: string;
  }

  interface IGit {
    branch: string;
    commit: ICommit;
  }

  interface ICommit {
    id: string;
    time: string;
  }

}

declare const ACTUATOR: Actuator.IActuator;
