package pentagon.model;

import java.util.Scanner;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;

public class TestScribe {
	//
	// public static void main(String[] args) {
	// OAuthService service = new
	// ServiceBuilder().provider(TwitterApi.SSL.class)
	// .apiKey("DI2edlYDMbE6ncLaY3Xb4w")
	// .apiSecret("KFoi5THfOOMNBb0mQEeBUVTmm1JESFnBIbVZ9t87vY")
	// .build();
	// Token requestToken = service.getRequestToken();
	// String authUrl = service.getAuthorizationUrl(requestToken);
	// System.out.println(authUrl);
	// // System.out.println(authUrl);
	// Verifier v = new Verifier(authUrl);
	// Token accessToken = service.getAccessToken(requestToken, v);
	//
	// OAuthRequest request = new OAuthRequest(Verb.GET,
	// "http://api.twitter.com/1/account/verify_credentials.xml");
	// service.signRequest(accessToken, request);
	// Response response = request.send();
	// System.out.println(response.getBody());
	// }

	private static final String PROTECTED_RESOURCE_URL1 = "https://api.twitter.com/1.1/account/verify_credentials.json";
	private static final String PROTECTED_RESOURCE_URL2 = "https://api.twitter.com/1.1/search/tweets.json?q=grand%20canyon&count=4";

	public static void main(String[] args) {
		// If you choose to use a callback, "oauth_verifier" will be the return
		// value by Twitter (request param)
		OAuthService service = new ServiceBuilder()
				.provider(TwitterApi.SSL.class).apiKey("RlwN23E3OgcGV6wCJzA0A")
				.apiSecret("uHM1wCrDHK7JoCF7uV4aetM6ujVbUtTTYOyT70MKyK4")
				.callback("oob").build();
		Scanner in = new Scanner(System.in);

		System.out.println("=== Twitter's OAuth Workflow ===");
		System.out.println();

		// Obtain the Request Token
		System.out.println("Fetching the Request Token...");
		Token requestToken = service.getRequestToken();
		System.out.println(requestToken.getRawResponse());
		System.out.println("Got the Request Token!");
		System.out.println();

		System.out.println("Now go and authorize Scribe here:");
		System.out.println(service.getAuthorizationUrl(requestToken));
		System.out.println("And paste the verifier here");
		System.out.print(">>");
		Verifier verifier = new Verifier(in.nextLine());
		System.out.println();

		// Trade the Request Token and Verfier for the Access Token
		System.out.println("Trading the Request Token for an Access Token...");
		Token accessToken = service.getAccessToken(requestToken, verifier);
		// Token accessToken = new
		// Token("2328118032-45gf7dU58F18TJVcOCr8j8h4TC5HWuUSffn8Mmx",
		// "kAHhgXpRXJnnfdknWHjb1GWQS8e7Ae07d3k6oOvammTSx");
		System.out.println("Got the Access Token!");
		System.out.println("(if your curious it looks like this: "
				+ accessToken + " )");
		System.out.println();

		// Now let's go and ask for a protected resource!
		System.out.println("Now we're going to access a protected resource...");
		OAuthRequest request = new OAuthRequest(Verb.GET,
				PROTECTED_RESOURCE_URL1);
		service.signRequest(accessToken, request);
		Response response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		System.out.println(response.getBody());

		// Now let's go and ask for a protected resource!
		System.out.println("Now we're going to access a protected resource...");
		request = new OAuthRequest(Verb.GET,
				PROTECTED_RESOURCE_URL2);
		service.signRequest(accessToken, request);
		response = request.send();
		System.out.println("Got it! Lets see what we found...");
		System.out.println();
		System.out.println(response.getBody());

		System.out.println();
		System.out
				.println("Thats it man! Go and build something awesome with Scribe! :)");
	}
}
