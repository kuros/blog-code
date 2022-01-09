import { SetMetadata } from "@nestjs/common";
import { Role } from "./entities/role.enum";

export const Roles=(...roles: Role [])=>SetMetadata('roles',roles)