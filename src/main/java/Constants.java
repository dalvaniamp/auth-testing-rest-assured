import org.json.JSONObject;

public final  class Constants {
	public static final String VALID_API_KEY = "$2a$10$D78U670fakY9XzQWonoBQej9nBBFB6d949WhINQxli277Yh4zQROq";
	
	public static JSONObject getCreateJson() {
		JSONObject json = new JSONObject();
		json.put("name", "TIE Advanced Checkout");
		json.put("model", "Twin Ion Engine Advanced Checkout");
		json.put("manufacturer", "Sienar Fleet Systems");
		json.put("cost_in_credits", "unknown");
		json.put("length", "9.8");
		json.put("max_atmosphering_speed", "1400");
		json.put("crew", "4");
		json.put("passengers", "0");
		json.put("cargo_capacity", "300");
		json.put("consumables", "13 days");
		json.put("hyperdrive_rating", "1.9");
		json.put("MGLT", "111");
		json.put("starship_class", "Starfighter");
		json.put("pilots", new String[0]);
		json.put("films", new String[0]);
		json.put("created","2014-12-12T11:21:32.991000Z");
		json.put("edited","2014-12-22T17:35:44.549047Z");
		return json;
	}
	
	public static JSONObject getUpdateJson() {
		JSONObject json = new JSONObject();
		json.put("name", "changed name");		
		return json;
	}
}
