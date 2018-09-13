import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable(/*{
  providedIn: 'root'
}*/)
export class ModuleService {

    public API = '//localhost:8080';
    public MODULE_API = this.API + '/module';

    constructor(private http: HttpClient) {
    }

    getAll(): Observable<any> {
        return this.http.get(this.MODULE_API + '/all');
    }

    get(id: string) {
        return this.http.get(this.MODULE_API + '/' + id);
    }

    save(module: any): Observable<any> {
        let result: Observable<Object>;
       /* if (module['href']) {
            result = this.http.put(module.href, module);
        } else {*/
            result = this.http.post(this.MODULE_API + "/save", module);
        //}
        return result;
    }

    remove(href: string) {
        return this.http.delete(this.MODULE_API + "/delete/" + href);
    }
}
