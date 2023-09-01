import { Component } from '@angular/core';
import { AgenteService } from 'src/app/service/agente-service';

@Component({
  selector: 'app-upload-list',
  templateUrl: './upload-list.component.html',
  styleUrls: ['./upload-list.component.css']
})
export class UploadListComponent {

 public agentes: any;
 public regiao:any;
 displayedColumns: string[] = ['codigo',  'data'];

  constructor(private service: AgenteService) { }



  buscarPorRegiao(regiao:any) {
    this.agentes = [];
    this.service.buscarPorRegiao(regiao)
      .then(agentes => {
        this.agentes = agentes;
        console.log(agentes)
      }).catch(erro => {
        alert(erro)
      });
  }

}
