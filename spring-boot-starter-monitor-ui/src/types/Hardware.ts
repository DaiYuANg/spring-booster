export interface Hardware {
  computerSystem:ComputerSystem
}

export interface ComputerSystem{
  baseboard:Baseboard;
  firmware:Firmware;
  hardwareUUID:string;
  manufacturer:string;
  model:string,
  serialNumber:string

}

export interface Baseboard{

}

export interface Firmware{

}
