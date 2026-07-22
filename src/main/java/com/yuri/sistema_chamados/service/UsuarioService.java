package com.yuri.sistema_chamados.service;

import com.yuri.sistema_chamados.dto.UsuarioRequestDTO;
import com.yuri.sistema_chamados.model.Empresa;
import com.yuri.sistema_chamados.model.Usuario;
import com.yuri.sistema_chamados.repository.EmpresaRepository;
import com.yuri.sistema_chamados.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Usuario cadastrar(UsuarioRequestDTO dto) {
        Empresa empresa = empresaRepository.findById(dto.getIdEmpresa())
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

        Usuario usuario = new Usuario();
        usuario.setNome(dto.getNome());
        usuario.setEmail(dto.getEmail());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setTipoUsuario(dto.getTipoUsuario());
        usuario.setEmpresa(empresa);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Usuario editar(Integer id, Usuario usuarioAtualizado) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        usuario.setNome(usuarioAtualizado.getNome());
        usuario.setEmail(usuarioAtualizado.getEmail());
        usuario.setTipoUsuario(usuarioAtualizado.getTipoUsuario());
        return usuarioRepository.save(usuario);
    }

    public void deletar(Integer id) {
        usuarioRepository.deleteById(id);
    }
}