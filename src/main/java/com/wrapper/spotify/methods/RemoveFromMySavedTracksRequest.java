package com.wrapper.spotify.methods;

import com.google.common.base.Joiner;
import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.exceptions.*;

import java.io.IOException;
import java.util.List;

public class RemoveFromMySavedTracksRequest extends AbstractRequest {

  public RemoveFromMySavedTracksRequest(Builder builder) {
    super(builder);
  }

  public SettableFuture<String> getAsync() {
    final SettableFuture<String> removeFromMyTracksFuture = SettableFuture.create();

    try {
      removeFromMyTracksFuture.set(deleteJson());
    } catch (Throwable e) {
      removeFromMyTracksFuture.setException(e);
    }

    return removeFromMyTracksFuture;
  }

  public String get() throws
          IOException,
          NoContentException,
          BadRequestException,
          UnauthorizedException,
          ForbiddenException,
          NotFoundException,
          TooManyRequestsException,
          InternalServerErrorException,
          BadGatewayException,
          ServiceUnavailableException {
    return deleteJson();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends AbstractRequest.Builder<Builder> {

    public Builder tracks(List<String> trackIds) {
      String idsParameter = Joiner.on(",").join(trackIds);
      return parameter("ids", idsParameter);
    }

    @Override
    public RemoveFromMySavedTracksRequest build() {
      return new RemoveFromMySavedTracksRequest(this);
    }
  }

}
