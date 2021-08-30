package com.example.services.user;

import com.example.api.response.user.USessionResponse;
import com.example.dtos.user.USessionTimeDTO;

public interface IUSessionService {
	USessionResponse findAllSessionInDay(USessionTimeDTO dto);
}
