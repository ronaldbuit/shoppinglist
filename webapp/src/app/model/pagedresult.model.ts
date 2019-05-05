export class PagedResult<T> {
  pageNumber: number;
  pageSize: number;
  totalCount: number;
  results: T;
}
