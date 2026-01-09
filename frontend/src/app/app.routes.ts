import { Routes } from '@angular/router';
import { ConsultaComponent } from './features/empresas/components/consulta/consulta.component';

export const routes: Routes = [
  // rota inicial → já abre Empresas Cadastradas
  { path: '', component: ConsultaComponent },

  // (opcional) manter por compatibilidade ou remover depois
  { path: 'consulta', component: ConsultaComponent },

  // fallback
  { path: '**', redirectTo: '' }
];
