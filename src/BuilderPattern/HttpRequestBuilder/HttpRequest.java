package builder.httprequestbuilder;

import builder.httprequestbuilder.enums.HttpMethods;

import java.util.HashMap;
import java.util.Map;

class HttpRequest {
	// Mandatory
	private final String url;
	private final HttpMethods httpMethod; 

	// Optional
	private final Map<String, String> headers;
	private final Map<String, String> queryParams;
	private final String body;
	private final String authToken;
	private final int timeout;

	private HttpRequest(Builder builder) {
		this.url = builder.url;
		this.httpMethod = builder.httpMethod;
		this.headers = builder.headers;
		this.queryParams = builder.queryParams;
		this.body = builder.body;
		this.timeout = builder.timeout;
		this.authToken = builder.authToken;
	}

	@Override
	public String toString() {
		return "HttpRequest{" +
          	"url='" + this.url + '\'' +
            ", method='" + this.httpMethod + '\'' +
            ", headers=" + this.headers +
            ", queryParams=" + this.queryParams +
            ", body='" + this.body + '\'' + 
            ", authToken='" + this.authToken + '\'' +
            ", timeout=" + this.timeout +
        '}';
	}

	public static class Builder {
		private final String url;
		private HttpMethods httpMethod = HttpMethods.GET; 

		private Map<String, String> headers = new HashMap<String, String>(); 
		private Map<String, String> queryParams = new HashMap<String, String>();
		private String body;
		private String authToken;
		private int timeout;

		public Builder(String url) {
			this.url = url;
		}

		public Builder(String url, HttpMethods httpMethod) {
			this.url = url;
			this.httpMethod = httpMethod;
		}

		public Builder addHeaders(String key, String value) {
			this.headers.put(key, value);
			return this;
		}

		public Builder addQueryParams(String key, String value) {
			this.queryParams.put(key, value);
			return this;
		}

		public Builder addBody(String body) {
			this.body = body;
			return this;
		}

		public Builder addAuthToken(String authToken) {
			this.authToken = authToken;
			return this;
		}

		public Builder addTimeout(int timeout) {
			this.timeout = timeout;
			return this;
		}

		public HttpRequest build() {
			return new HttpRequest(this);
		}
	} 
}
