import { Injectable } from '@angular/core';
import {
    CanActivate, Router,
    ActivatedRouteSnapshot,
    RouterStateSnapshot
} from '@angular/router';
import { AuthenticationService } from './authentication.service';

@Injectable()
export class AuthGuard implements CanActivate {

    private accessMap: Object = {
        "everyone": [],
        "enseignant": ["/etudiant-list"],
        "etudiant": ["/ficheeleve"]
    };

    constructor(private authService: AuthenticationService, private router: Router) {}

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        let url: string = state.url;

        return this.checkLogin(url);
    }

    checkLogin(url: string): boolean {
        console.log(url);
        if (this.authService.isLoggedIn) {
            const userType = this.authService.currentUser.userType;

            if(this.accessMap["everyone"][url]
                || userType == "admin"
                || userType == "enseignant"// debug - allow enseignant anywhere
                || this.accessMap[userType][url]// check that page is within user's rights
            ) {
                return true;
            } else {

            }
        }
        return false;
    }
}