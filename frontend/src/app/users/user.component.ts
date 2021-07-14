import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

import { AppService } from './users.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class AppComponent implements OnInit {
  
  contatos: Array<any>;
  contato: any;

  constructor(private service: AppService) {}

  ngOnInit() {
    this.contato = {};

    this.service.listar()
      .subscribe(resposta => this.contatos = resposta);
  }

  criar(frm: FormGroup) {
    this.service.criar(this.contato).subscribe(resposta => {
      this.contatos.push(resposta);

      frm.reset();
    });
  }
}
