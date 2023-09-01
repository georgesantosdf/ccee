
import { Component, ViewChild } from '@angular/core';
import { AgenteService } from 'src/app/service/agente-service';
import * as converter from 'xml-js';

@Component({
  selector: 'app-upload-form',
  templateUrl: './upload-form.component.html',
  styleUrls: ['./upload-form.component.css']
})
export class uploadFormComponent {

  @ViewChild('arquivo') fileshtml:any;

  porcentagemUpload = 0;
  valueProgress = 0;
  loading = 'none';


  constructor(private service: AgenteService) {
  }


  public upload(event: any) {
    this.loading = 'block';
     for(let file of event.target.files) {
       const reader: FileReader = new FileReader();
       reader.onload = (ev: any) => {
         let xml = ev.target.result;
         let result1 = converter.xml2json(xml, { compact: true, spaces: 2 });
         let JSONData:any = JSON.parse(result1);

         let arr:any = [];

         if(Array.isArray(JSONData.agentes.agente)){
          arr = JSONData.agentes.agente;
         }else{
            arr.push(JSONData.agentes.agente);
         }
          this.criarListaDeagentes(arr);
     }
     reader.readAsText(file);
   }
 }

 private criarListaDeagentes(obj: any) {

    let i = 0;
      for(let item of obj) {
        let regioes = [];

        for(let r of item.regiao) {
          let reg  = {
            sigla:r._attributes.sigla,
            compra: { valor : this.ajustarLista(r.compra.valor)},
            geracao:{ valor : this.ajustarLista(r.geracao.valor)}
          };
          regioes.push(reg);
        }
        let agente = {codigo : item.codigo._text, data : item.data._text, regioes: regioes};
        this.progress(obj.size, i++)
        this.post(agente);
      }
      alert("Arquivos Enviado com Sucesso");
      this.valueProgress = 0;
      this.loading = 'none';
 }

 private progress(val: number, i: number) {
   return ((val * i) / 100) * 10;
 }

 private ajustarLista(valores:any){
  let list = [];
  for(let c of valores) {
     list.push(c._text);
  }
  return list;
 }

 private post(agente:any) {
  this.service.post(agente).subscribe({
    next: (data) => {
        }, error: (e) => alert("Error --> " + e.error)
      });
}

}
