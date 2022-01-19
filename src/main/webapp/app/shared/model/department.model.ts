import { ILocation } from '@/shared/model/location.model';
import { IEmployee } from '@/shared/model/employee.model';

export interface IDepartment {
  id?: number;
  departmentName?: string;
  price?: number;
  location?: ILocation | null;
  employees?: IEmployee[] | null;
}

export class Department implements IDepartment {
  constructor(
    public id?: number,
    public departmentName?: string,
    public price?: number,
    public location?: ILocation | null,
    public employees?: IEmployee[] | null
  ) {}
}
