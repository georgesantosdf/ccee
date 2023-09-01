import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { firstValueFrom, Observable, pipe, throwError } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AgenteService {

  private apiURL = 'http://localhost:8080/agentes';

  constructor(private http: HttpClient) { }

  post(data : any) {
      return this.http.post<any>(`${ this.apiURL }`, data);
  }

  buscarPorRegiao(regiao:any) {
    return firstValueFrom(
      this.http.get(this.apiURL + "/regiao/" + regiao)
    );
  }

}
