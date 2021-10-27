import { Module } from '@nestjs/common';
import { AppController } from './app.controller';
import { AppService } from './app.service';
import { StorageModule } from './storage/storage.module';
import { MediaModule } from './media/media.module';

@Module({
  imports: [StorageModule, MediaModule],
  controllers: [AppController],
  providers: [AppService],
})
export class AppModule {}
