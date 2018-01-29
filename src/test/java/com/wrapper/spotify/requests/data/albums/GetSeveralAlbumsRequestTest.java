package com.wrapper.spotify.requests.data.albums;

import com.wrapper.spotify.ITest;
import com.wrapper.spotify.TestUtil;
import com.wrapper.spotify.exceptions.SpotifyWebApiException;
import com.wrapper.spotify.model_objects.specification.Album;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class GetSeveralAlbumsRequestTest implements ITest<Album[]> {

  private final GetSeveralAlbumsRequest defaultRequest = SPOTIFY_API.getSeveralAlbums("id")
          .setHttpManager(TestUtil.MockedHttpManager.returningJson("requests/data/albums/GetSeveralAlbumsRequest.json"))
          .build();

  private final GetSeveralAlbumsRequest emptyRequest = SPOTIFY_API.getSeveralAlbums("id")
          .setHttpManager(TestUtil.MockedHttpManager.returningJson("requests/data/albums/GetSeveralAlbumsRequest_None.json"))
          .build();

  public GetSeveralAlbumsRequestTest() throws Exception {
  }

  @Test
  public void shouldReturnDefault_sync() throws IOException, SpotifyWebApiException {
    shouldReturnDefault(defaultRequest.execute());
  }

  @Test
  public void shouldReturnDefault_async() throws ExecutionException, InterruptedException {
    shouldReturnDefault((Album[]) defaultRequest.executeAsync().get());
  }

  public void shouldReturnDefault(final Album[] albums) {
    assertEquals(
            1,
            albums.length);
  }

  @Test
  public void shouldReturnEmpty_sync() throws IOException, SpotifyWebApiException {
    shouldReturnEmpty(emptyRequest.execute());
  }

  @Test
  public void shouldReturnEmpty_async() throws ExecutionException, InterruptedException {
    shouldReturnEmpty((Album[]) emptyRequest.executeAsync().get());
  }

  public void shouldReturnEmpty(final Album[] albums) {
    assertEquals(
            0,
            albums.length);
  }
}
