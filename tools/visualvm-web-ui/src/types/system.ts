type ThreadDetail = {
  contextSwitches: number;
  kernelTime: number;
  majorFaults: number;
  minorFaults: number;
  name: string;
  owningProcessId: number;
  priority: number;
  startMemoryAddress: number;
  startTime: number;
  state: string;
  threadCpuLoadCumulative: number;
  threadId: number;
  upTime: number;
  userTime: number;
};

type Process = {
  affinityMask: number;
  arguments: Array<string>;
  bitness: number;
  bytesRead: number;
  bytesWritten: number;
  commandLine: string;
  contextSwitches: number;
  currentWorkingDirectory: string;
  environmentVariables: string;
  group: string;
  groupID: string;
  hardOpenFileLimit: number;
  kernelTime: number;
  majorFaults: number;
  minorFaults: number;
  name: string;
  openFiles: number;
  parentProcessID: number;
  path: string;
  priority: number;
  processCpuLoadCumulative: number;
  processID: number;
  residentSetSize: number;
  softOpenFileLimit: number;
  startTime: number;
  state: number;
  threadCount: number;
  upTime: number;
  user: string;
  userID: string;
  userTime: number;
  virtualSize: number;
  threadDetails: Array<ThreadDetail>;
};

type Service = {
  name: string;
  processID: number;
  state: string;
};

export type { Process, Service, ThreadDetail };
