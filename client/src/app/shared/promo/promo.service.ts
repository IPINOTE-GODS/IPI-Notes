import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable(/*{
  providedIn: 'root'
}*/)
export class PromoService {

    public API = '//localhost:8080';
    public PROMO_API = this.API + '/formation';

    constructor(private http: HttpClient) {
    }

    getAll(): Observable<any> {
        return this.http.get(this.PROMO_API + '/all');
    }

    get(id: string) {
        return this.http.get(this.PROMO_API + '/' + id);
    }

    save(promo: any, annee: any): Observable<any> {
        let result: Observable<Object>;
       /* if (promo['href']) {
            result = this.http.put(promo.href, promo);
        } else {*/
            result = this.http.post(this.PROMO_API + "/save/" + annee, promo);
        //}
        return result;
    }

    remove(href: string) {
        return this.http.delete(this.PROMO_API + "/delete/" + href);
    }
}
