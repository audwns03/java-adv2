package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-txt.dat";
    private static final String DELIMITER = ",";

    @Override
    public void add(Member member) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_PATH, StandardCharsets.UTF_8, true));){
            bufferedWriter.write(member.getId() + DELIMITER + member.getName() + DELIMITER + member.getAge());
            bufferedWriter.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public List<Member> findAll() {

        List<Member> members = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH, StandardCharsets.UTF_8))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split(DELIMITER);
                members.add(new Member(split[0], split[1], Integer.parseInt(split[2])));
            }

        } catch (FileNotFoundException e) {
            return List.of();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return members;
    }
}
