/*
 * Copyright (c) 2020, Wild Adventure
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 3. Neither the name of the copyright holder nor the names of its
 *    contributors may be used to endorse or promote products derived from
 *    this software without specific prior written permission.
 * 4. Redistribution of this software in source or binary forms shall be free
 *    of all charges or fees to the recipient of this software.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gmail.filoghost.holographicmobs.nms.v1_8_R3.skeleton;

import lombok.Getter;
import lombok.Setter;
import net.minecraft.server.v1_8_R3.AxisAlignedBB;
import net.minecraft.server.v1_8_R3.DamageSource;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityDamageSource;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.EntitySkeleton;
import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityEquipment;
import net.minecraft.server.v1_8_R3.World;
import net.minecraft.server.v1_8_R3.WorldServer;

import org.bukkit.craftbukkit.v1_8_R3.entity.CraftEntity;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;

import com.gmail.filoghost.holographicmobs.nms.v1_8_R3.NullBoundingBox;
import com.gmail.filoghost.holographicmobs.nms.interfaces.NMSHolographicSkeleton;
import com.gmail.filoghost.holographicmobs.object.HologramMob;

public class EntityHolographicSkeleton extends EntitySkeleton implements NMSHolographicSkeleton {
	
	@Setter
	private boolean lockTick;
	
	@Getter
	private HologramMob parent;
	
	public EntityHolographicSkeleton(World world, HologramMob parent) {
		super(world);
		this.parent = parent;
		super.persistent = true;
		
		forceSetBoundingBox(new NullBoundingBox());
	}
	
	@Override
	public void a(AxisAlignedBB boundingBox) {
		// Do not change it!
	}
	
	public void forceSetBoundingBox(AxisAlignedBB boundingBox) {
		super.a(boundingBox);
	}
	
	@Override
	public void m() {
		if (!lockTick) {
			super.m();
		}
	}
	
	@Override
	public void b(NBTTagCompound nbttagcompound) {
		// Do not save NBT.
	}
	
	@Override
	public boolean c(NBTTagCompound nbttagcompound) {
		// Do not save NBT.
		return false;
	}

	@Override
	public boolean d(NBTTagCompound nbttagcompound) {
		// Do not save NBT.
		return false;
	}
	
	@Override
	public void e(NBTTagCompound nbttagcompound) {
		// Do not save NBT.
	}
	
	@Override
	public void collide(Entity entity) {
		// Do not collide
	}

	public boolean isCollidable() {
		return false;
	}
	
	@Override
	public boolean isInvulnerable(DamageSource damagesource) {
		/*
		 * The field Entity.invulnerable is private.
		 * It's only used while saving NBTTags, but since the entity would be killed
		 * on chunk unload, we prefer to override isInvulnerable().
		 */
	    return true;
	}
	
	@Override
	public boolean damageEntity(DamageSource damageSource, float f) {
		if (damageSource instanceof EntityDamageSource) {
			EntityDamageSource entityDamage = (EntityDamageSource) damageSource;
			
			if (entityDamage.getEntity() instanceof EntityPlayer) {
				parent.onInteract(((EntityPlayer) entityDamage.getEntity()).getBukkitEntity());
			}
		}
		
		return false;
	}

	@Override
	public void setCustomName(String customName) {
		// Locks the custom name.
	}
	
	@Override
	public void setCustomNameVisible(boolean visible) {
		// Locks the custom name.
	}
	
	@Override
	public void die() {
		// Prevent being killed.
	}

	@Override
	public void setCustomNameNMS(String name) {
		if (name != null && name.length() > 300) {
			name = name.substring(0, 300);
		}
		super.setCustomName(name);
		super.setCustomNameVisible(name != null);
	}
	
	@Override
	public CraftEntity getBukkitEntity() {
		if (super.bukkitEntity == null) {
			this.bukkitEntity = new CraftHolographicSkeleton(this.world.getServer(), this);
	    }
		return this.bukkitEntity;
	}

	@Override
	public boolean isDeadNMS() {
		return this.dead;
	}

	@Override
	public String getCustomNameNMS() {
		return super.getCustomName();
	}
	
	@Override
	public void killEntityNMS() {
		super.dead = true;
	}
	
	@Override
	public void setLocationNMS(double x, double y, double z, float yaw, float pitch) {
		super.setLocation(x, y, z, yaw, pitch);
		super.aK = yaw; // https://hub.spigotmc.org/stash/projects/SPIGOT/repos/craftbukkit/commits/5245147d004f648afcddec6a689e60d451c027bf
	}

	@Override
	public void setItemInHandNMS(org.bukkit.inventory.ItemStack item) {
		setEquipment(0, item != null ? CraftItemStack.asNMSCopy(item) : null);
	}

	@Override
	public void setItemInOffHandNMS(org.bukkit.inventory.ItemStack item) {
	}

	@Override
	public void setHelmetNMS(org.bukkit.inventory.ItemStack item) {
		setEquipment(103, item != null ? CraftItemStack.asNMSCopy(item) : null);
	}

	@Override
	public void setChestplateNMS(org.bukkit.inventory.ItemStack item) {
		setEquipment(102, item != null ? CraftItemStack.asNMSCopy(item) : null);
	}

	@Override
	public void setLeggingsNMS(org.bukkit.inventory.ItemStack item) {
		setEquipment(101, item != null ? CraftItemStack.asNMSCopy(item) : null);
	}

	@Override
	public void setBootsNMS(org.bukkit.inventory.ItemStack item) {
		setEquipment(100, item != null ? CraftItemStack.asNMSCopy(item) : null);
	}

	@Override
	public void sendEquipPacketNMS() {

	}

}
