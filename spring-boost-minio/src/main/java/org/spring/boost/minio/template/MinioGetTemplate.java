/* (C)2024*/
package org.spring.boost.minio.template;

import io.minio.GetObjectArgs;
import io.minio.GetObjectResponse;
import io.minio.errors.*;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import lombok.experimental.SuperBuilder;
import lombok.val;

@SuperBuilder
public class MinioGetTemplate extends MinioTemplate {
	public GetObjectResponse getObject(String object)
			throws ServerException, InsufficientDataException, ErrorResponseException, IOException,
					NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException,
					InternalException {
		val arg = GetObjectArgs.builder().object(object).build();
		return client.getObject(arg);
	}

	public Optional<GetObjectResponse> getObjectOptional(String object) {
		try {
			return Optional.of(getObject(object));
		} catch (ErrorResponseException
				| InsufficientDataException
				| InternalException
				| InvalidKeyException
				| InvalidResponseException
				| IOException
				| NoSuchAlgorithmException
				| ServerException
				| XmlParserException e) {
			return Optional.empty();
		}
	}

	public Optional<GetObjectResponse> getObjectByTag(String tag) {
		val arg = GetObjectArgs.builder().matchETag(tag).build();
		try {
			return Optional.of(client.getObject(arg));
		} catch (ErrorResponseException
				| InsufficientDataException
				| InternalException
				| InvalidKeyException
				| InvalidResponseException
				| IOException
				| NoSuchAlgorithmException
				| ServerException
				| XmlParserException e) {
			return Optional.empty();
		}
	}
}
