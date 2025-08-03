package com.example.demo_Kotlin.service.implement

import com.example.demo_Kotlin.dto.ClientDto
import com.example.demo_Kotlin.entity.parameter.Client
import com.example.demo_Kotlin.entity.security.Person
import com.example.demo_Kotlin.irespository.IBaseRepository
import com.example.demo_Kotlin.irespository.IClientRepository
import com.example.demo_Kotlin.irespository.IPersonRepository
import com.example.demo_Kotlin.service.`interface`.IClientService
import com.example.demo_Kotlin.utilitis.GenericMapper
import org.springframework.stereotype.Service

@Service

class ClientService (
    private val ClientRepository: IClientRepository,
mapper: GenericMapper
) : ABaseService<Client, ClientDto>(mapper, Client::class.java, ClientDto::class.java), IClientService {

    override fun getRepository(): IBaseRepository<Client, Long> {
        return ClientRepository
    }
    }