package com.mkyong.rest;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

@Path("/json/product")
public class JSONService {
	
	private static final String FILE_PATH = "C:\\Java_WP\\desktop.png";

	@GET
	@Path("/get")
	@Produces("image/png")
	public byte[] getProductInJSON() {

		/*Product product = new Product();
		product.setName("https://www.google.com/maps/search/?api=1&query=idly");
		//product.setQty(999);
		
		return product; */
		
		File file = new File(FILE_PATH);

		/*ResponseBuilder response = Response.ok((Object) file);
		response.header("Content-Disposition",
			"attachment; filename=image_from_server.png");
		return response.build();*/
		
		BufferedImage image;
		try {
			image = ImageIO.read(file);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    ImageIO.write(image, "png", baos);
		    byte[] imageData = baos.toByteArray();
		    return imageData;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@POST
	@Path("/post")
	@Consumes("application/json")
	public Response createProductInJSON(Product product) {

		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();
		
	}
	
}