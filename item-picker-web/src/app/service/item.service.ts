import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { firstValueFrom } from "rxjs";
import { ItemModel } from "../model/item.model";
import { environment } from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  private apiUrl = environment.apiUrl;

  constructor(
    private http: HttpClient,
  ) {
  }

  getItemsBatch() {
    return firstValueFrom(this.http.get<ItemModel[]>(`${this.apiUrl}/gameplay/batch`));
  }

  postVotesBatch(request: {
    votesBatch: string[],
  }) {
    return firstValueFrom(this.http.post<string[]>(`${this.apiUrl}/gameplay/batch`, request))
  }
}
