import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ImageUploaderComponent } from './image-uploader/image-uploader.component';
import { ImageDisplayComponent } from './image-display/image-display.component';
import { ImageService } from "./image.service";
import { FileSelectDirective, FileDropDirective } from "ng2-file-upload/ng2-file-upload";

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [ImageUploaderComponent, ImageDisplayComponent, FileSelectDirective, FileDropDirective],
  providers: [ImageService],
  exports: [ImageUploaderComponent, ImageDisplayComponent]
})
export class ImageModule { }
