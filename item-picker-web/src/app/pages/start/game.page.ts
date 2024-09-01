import { Component, OnInit } from '@angular/core';
import { ItemModel } from "../../model/item.model";
import { ItemService } from "../../service/item.service";

@Component({
  selector: 'app-game',
  standalone: true,
  imports: [],
  templateUrl: './game.page.html',
  styleUrls: ['./game.page.css']
})
export class GamePage implements OnInit {
  itemsBatch: ItemModel[] = [];
  selectedItems: string[] = [];
  shownItems: ItemModel[] = [];
  itemsCounter: number = 0;

  constructor(private itemService: ItemService) {}

  async ngOnInit() {
    await this.loadItems();
  }

  async loadItems() {
    this.itemsBatch = await this.itemService.getItemsBatch();
    this.shownItems = this.itemsBatch.splice(0, 2);
  }

  async chooseItem(id: string) {
    this.selectedItems.push(id);
    this.itemsCounter += 1;

    if (this.selectedItems.length % 3 === 0) {
      await this.itemService.postVotesBatch({
        votesBatch: this.selectedItems,
      });
      this.selectedItems = [];
      await this.loadItems();
    } else {
      this.shownItems = this.itemsBatch.splice(0, 2);
    }
  }
}
