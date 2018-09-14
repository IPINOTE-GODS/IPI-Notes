import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class EnseignantService {
    public API = '//localhost:8080';
    public ENSEIGNANT_API = this.API + '/enseignants';

    constructor(private http: HttpClient) {
    }

    getAll(): Observable<any> {
        return this.http.get(this.ENSEIGNANT_API + '/all');
    }

    get(id: string) {
        return this.http.get(this.ENSEIGNANT_API + '/' + id);
    }

    save(enseignant: any): Observable<any> {
        let result: Observable<Object>;
        if (enseignant['href']) {
            result = this.http.put(enseignant.href, enseignant);
        } else {
            result = this.http.post(this.ENSEIGNANT_API, enseignant);
        }
        return result;
    }

    remove(href: string) {
        return this.http.delete(href);
    }
}