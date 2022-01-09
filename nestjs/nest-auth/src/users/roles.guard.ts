import { Injectable,CanActivate,ExecutionContext } from "@nestjs/common";
import { Reflector } from "@nestjs/core";
import { Observable } from "rxjs";
import { Role } from "./entities/role.enum";
import { User } from "./entities/user.entity";
@Injectable()
export class RolesGuard implements CanActivate{
    constructor(private reflector:Reflector){}
    canActivate(context: ExecutionContext): boolean {
        const requireRoles=this.reflector.getAllAndOverride<Role[]>('roles',[
            context.getHandler(),
            context.getClass(),
        ]);

        if (!requireRoles){
            return true;
        }
        //const {user}=context.switchToHttp().getRequest();
        const user:User={
            name:'Nishant',
            roles:[Role.USER]
        }
        return requireRoles.some(role=>user.roles.includes(role));
    }
}