import { TestBed } from '@angular/core/testing';

import { GroundService } from './ground.service';

describe('GroundNameService', () => {
  let service: GroundService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GroundService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
