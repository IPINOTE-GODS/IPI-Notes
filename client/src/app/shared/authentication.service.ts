import { Injectable } from '@angular/core';
import {HttpClient, HttpParams, HttpHeaders} from "@angular/common/http";
import { Observable } from 'rxjs';
import { Response } from '@angular/http';
//import{ AppConstants} from '../app/constants'

@Injectable(/*{
  providedIn: 'root'
}*/)
export class AuthenticationService {
    _token : any;
 
    constructor(private _htc:HttpClient) {
        var currentUser = JSON.parse(localStorage.getItem('currentUser'));
        this._token = currentUser && currentUser.token;
    }
	login(username: string, password: string): Observable<boolean> {

        const headers = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});

        return this._htc.post(
            'http://localhost:8080/authenticate', 
            JSON.stringify({username: username, password: password }),
            { headers: headers }
        )
		.map((response: Response) => {
			// login successfully, if there is a jwt token in the response
			let token = response;//response.json() && response.json().token;
			if (token) {
				//set the token property for validate token in the app.
				this._token = token;

				//store username and jwt token in local storage to keep user logged in between page refreshes.
				localStorage.setItem('currentUser', JSON.stringify({ username: username, token: token }));

				//returns true to indicate successful login
				return true;
			} else {
				// returns false to indicate failed login
                return false;
            }
        });
	}

	logout(): void {
		// clear token remove user from local storage to log user out.
		this._token = null;
		localStorage.removeItem('currentUser');
    }
}