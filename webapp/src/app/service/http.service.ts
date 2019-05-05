import { Injectable } from "@angular/core";
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import { Observable } from "rxjs/index";
import { PagedResult } from "../model/pagedresult.model"
import {TokenService} from "./token.service";

@Injectable({
  providedIn: 'root'
})
export class HttpService
{
  baseURL: string;

  constructor(private http: HttpClient, private tokenService: TokenService)
  {
    this.baseURL = this.getBaseUrl();
  }

  private getBaseUrl(): string {
    return "http://localhost:8080/";
  }

  doGetRequest<T>(path: string): Observable<T>
  {
    return this.http.get<T>(this.baseURL + path, {headers: this.getAuthenticationHeader()});
  }

  private getAuthenticationHeader(): HttpHeaders
  {
    return new HttpHeaders({
      'Authorization':  'Bearer ' + this.tokenService.get()
    });
  }

  doGetPageRequest<T>(path: string, search: string, pageNumber: number, pageSize: number): Observable<PagedResult<T>>
  {
    return this.http.get<PagedResult<T>>(this.baseURL + path,
      {
        params: new HttpParams().set('search', search).set('pageNumber', String(pageNumber)).set('pageSize', String(pageSize))
      });
  }

  doPostRequest<T>(path: string, data): Observable<T>
  {
    return this.http.post<T>(this.baseURL + path, data);
  }

  doDeleteRequest(path: string): Observable<any>
  {
    return this.http.delete(this.baseURL + path);
  }
}
