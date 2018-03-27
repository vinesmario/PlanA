package com.common.util;

import com.github.pagehelper.PageInfo;
import org.springframework.http.HttpHeaders;
import org.springframework.web.util.UriComponentsBuilder;

public final class PaginationUtil {

	private PaginationUtil() {
	}

	public static HttpHeaders generatePaginationHttpHeaders(PageInfo page, String baseUrl) {

		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Total-Count", Long.toString(page.getTotal()));
		String link = "";
		if ((page.getPageNum() + 1) < page.getPages()) {
			link = "<" + generateUri(baseUrl, page.getPageNum() + 1, page.getSize()) + ">; rel=\"next\",";
		}
		// prev link
		if ((page.getPageNum()) > 0) {
			link += "<" + generateUri(baseUrl, page.getPageNum() - 1, page.getSize()) + ">; rel=\"prev\",";
		}
		// last and first link
		int lastPage = 0;
		if (page.getPages() > 0) {
			lastPage = page.getPages() - 1;
		}
		link += "<" + generateUri(baseUrl, lastPage, page.getSize()) + ">; rel=\"last\",";
		link += "<" + generateUri(baseUrl, 0, page.getSize()) + ">; rel=\"first\"";
		headers.add(HttpHeaders.LINK, link);
		return headers;
	}

	private static String generateUri(String baseUrl, int page, int size) {
		return UriComponentsBuilder.fromUriString(baseUrl).queryParam("page", page).queryParam("size", size).toUriString();
	}
}
