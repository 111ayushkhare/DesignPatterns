package builder.httprequestbuilder;


import builder.httprequestbuilder.enums.HttpMethods;


public class Driver {
	public static void main(String[] args) {
		HttpRequest request1 = new HttpRequest.Builder("http://chunks.in/win/1").build();

		HttpRequest request2 = new HttpRequest.Builder("http://chunks.in/win/2", HttpMethods.DELETE)
			.addHeaders("X-API-Key", "secret")
			.addQueryParams("id", "123")
			.addTimeout(10000)
			.build();

		HttpRequest request3 = new HttpRequest.Builder("http://chunks.in/win/3", HttpMethods.POST)
			.addHeaders("X-API-Key", "secret")
			.addQueryParams("sort", "desc")
			.addBody("{name:Sam}")
			.addTimeout(20000)
			.build();

		System.out.println(request1);
		System.out.println(request2);
		System.out.println(request3);
	}
}