package framework.core.dto;

import java.util.List;

import framework.core.util.AppConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagedResponse<T> extends CommonResponse {
    private List<T> content;
    private int page = AppConstants.DEFAULT_PAGE_NUMBER;
    private int size = AppConstants.DEFAULT_PAGE_SIZE;
    private long totalElements;
    private int totalPages;
    private boolean last;

    public void setPagedContent(List<T> content, Integer page, Integer size) {
        this.content = content;
        this.page = page != null ? page.intValue() : this.page;
        this.size = size != null ? size.intValue() : this.size;
        this.totalElements = this.content.size();
        this.totalPages = (int) (this.totalElements / this.size);
        this.last = this.page == this.totalPages;
    }
}
