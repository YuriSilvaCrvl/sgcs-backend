package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.dto.UsuarioRequestDTO;
import com.yuri.sistema_chamados.dto.UsuarioResponseDTO;
import com.yuri.sistema_chamados.model.Empresa;
import com.yuri.sistema_chamados.model.Usuario;
import com.yuri.sistema_chamados.repository.EmpresaRepository;
import com.yuri.sistema_chamados.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private UsuarioResponseDTO toDTO(Usuario usuario) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setEmail(usuario.getEmail());
        dto.setTipoUsuario(usuario.getTipoUsuario());
        dto.setIdEmpresa(usuario.getEmpresa().getId());
        dto.setNomeEmpresa(usuario.getEmpresa().getNome());
        return dto;
    }

    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {
        Empresa empresa = empresaRepository.findById(dto.getIdEmpresa())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setTipoUsuario(dto.getTipoUsuario());
        usuario.setEmpresa(empresa);

        return toDTO(usuarioRepository.save(usuario));
    }

    public List<UsuarioResponseDTO> listar() {
        return usuarioRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<UsuarioResponseDTO> buscarPorId(Integer id) {
        return usuarioRepository.findById(id).map(this::toDTO);
    }

    public Optional<UsuarioResponseDTO> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email).map(this::toDTO);
    }

    public Optional<Usuario> buscarEntidadePorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public UsuarioResponseDTO editar(Integer id, UsuarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setTipoUsuario(dto.getTipoUsuario());
        return toDTO(usuarioRepository.save(usuario));
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}